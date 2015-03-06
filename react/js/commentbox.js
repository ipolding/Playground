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
        handleCommentSubmit: function(comment) {
            var comments = this.state.data;
            var newComments = comments.concat([comment]); //add my comment to the array
            this.setState({data: newComments});
            $.ajax({
                url: this.props.url,
                dataType: 'json',
                type: 'POST',
                data: comment,
                success: function(data) {
                    this.setState({data: data});
                }.bind(this),
                error: function(xhr, status, err) {
                    console.error(this.props.urkl, status, err.toString());
                }.bind(this)
            });
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
                    <CommentForm onCommentSubmit={this.handleCommentSubmit}/>
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
        handleSubmit : function(e) {
            console.log("clicked submit");
            e.preventDefault();
            var author = this.refs.author.getDOMNode().value.trim();
            var text = this.refs.text.getDOMNode().value.trim();
            if (!text || !author) {
                return;
            }
            this.props.onCommentSubmit({author: author, text: text});
            this.refs.author.getDOMNode().value = '';
            this.refs.text.getDOMNode().value = '';           
        },

        render : function() {
            return (
        <form className="commentForm" onSubmit={this.handleSubmit}>
            <input type="text" placeholder="Your name" ref="author"/>
            <input type="text" placeholder="Say something..." ref="text" />
            <input type="submit" value="Post" />
        </form>        
           );
        }
    }
    );

React.render(
    <CommentBox url="http://localhost:1753/comments/comments.json" pollInterval={2000} />,
    document.getElementById('commentBox')
    );