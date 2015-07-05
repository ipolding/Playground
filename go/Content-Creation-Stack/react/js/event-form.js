var EventForm = React.createClass(
    {
        validateForm : function(e) {
            var title = this.refs.title.getDOMNode().value.trim();
            var address = this.refs.address.getDOMNode().value.trim();
            var description = this.refs.description.getDOMNode().value.trim();
            console.log("validation title=" + title);
            console.log("validation address=" + address);
            console.log("validation description=" + description);
        },

        handleSubmit : function(e) {
            this.validateForm();
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
        <form className="blogForm" onSubmit={this.handleSubmit}>
            <input type="text" placeholder="Title" ref="title"/>
            <input type="text" placeholder="Address" ref="address" />
            <input type="textarea" placeholder="Description" ref="description" />
            <input type="submit" value="Post" />
        </form>        
           );
        }
    }
    );

React.render(
    <EventForm  />,
    document.getElementById('eventForm')
    );