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
        <form onSubmit={this.handleSubmit} className="small-12 large-centered column">
            <div className="row">
                    <input type="text" placeholder="Title" ref="title" className="small-12 small-centered"/>
            </div>
            <div className="row">
                    <input type="text" placeholder="Address" ref="address" className="small-12 small-centered"/>
            </div>
            <div className="row">
                    <textarea type="type" placeholder="Description" ref="description" className="small-12 small-centered"/>
            </div>
            <div className="row">
                    <input type="submit" value="Create Blog" className="small-6 small-centered"/>
                    <button className="small-6 small-centered">Preview</button>
            </div>
        </form>        
           );
        }
    }
    );


React.render(
    <EventForm className="top bar"/>,
    document.getElementById('eventForm')
    );