var CommentBox = React.createClass({
        loadCommentsFromServer: function () {
            $.ajax({
                url: this.props.url, /* CommentBox must have a url attribute*/
                dataType: 'json',
                success: function(data) {
                    this.setState({data: data}); /* the data props gets set here*/
                }.bind(this),
                error: function(xhr, status, err) {
                    console.error(this.props.url, status, err.toString());
                }.bind(this)
                });
        },

        getInitialState: function() { /* Executes once in lifecycle of element*/
            return {data: []};
        },

        componentDidMount: function() { /* Called when an element is rendered */
            this.loadCommentsFromServer();
            setInterval(this.loadCommentsFromServer, this.props.pollInterval); /* How often do we call the server*/
        },
        render : function() { /* props == immutable; state == mutable*/
            return (
                <div className="commentBox">
                    <h1>CommentBox</h1>
                    <CommentList data={this.state.data}/> 
                    <CommentForm />
                </div>
                );
        }        
    });

var CommentList = React.createClass( /* has access to data*/
    {render : function() {
        var commentNodes = this.props.data.map(
            function (comment) { /* each object in data is passed in as "comment"*/
                return (
                    <Comment author={comment.author}>
                        {comment.text}
                    </Comment>
                    );
            });
        return (
            <div className="commentList">
                {commentNodes}
            </div>
            );
    }});

var Comment /*this*/ = React.createClass( 
    {render : function() {return (
        <div className="comment">
            <h2 className="commentAuthor">
                {this.props.author}
            </h2>
                {this.props.children}
        </div>        
        );}}
    );

var CommentForm = React.createClass(
    {
         /* We can expand the React object with our own functions */
        handleSubmit : function(e) {
            

        },



        render : function() {return (
        <div className="commentForm">
            <input type="text" placeholder="Your name" />
            <input type="text" placeholder="Say something..." />
            <input type="submit" value="Post" />
        </div>        
        );}}
    );


React.render(
    <CommentBox url="comments.json" pollInterval={2000} />,
    document.getElementById('content')
    );