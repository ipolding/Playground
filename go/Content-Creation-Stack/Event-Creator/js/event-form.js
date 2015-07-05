var EventForm = React.createClass(
    {   
        render : function() {
            return (
                <div> 
                <h1 >Post an Event</h1>
                <form  onSubmit={this.handleSubmit}>
                    <input type="text" placeholder="Event Title..." ref="title" />
                    <input type="text" placeholder="Event address..." ref="location" />
                    <textarea placeholder="Event Description..." ref="description" />
                    <input type="submit" value="Post" />
                </form>
                </div>
            );
        },

        handleSubmit : function(e) {
            e.preventDefault();
            console.log("clicked submit");
            this.validate();
            var title = this.refs.title.getDOMNode().value.trim();
            var description = this.refs.description.getDOMNode().value.trim();
            var location = this.refs.location.getDOMNode().value.trim();
            console.log("INSIDE event-form.js this.props.url = " + this.props.url);
            var eventObject = {"title": title, "location": location, "description":description};
            $.ajax({
                url: this.props.url,
                dataType: 'json',
                data: JSON.stringify(eventObject),
                type: 'POST',
                    error : function(xhr, status, err) {
                    console.error(eventObject, status, err.toString());
                }.bind(this)
                });         
        },

        validate: function() {
            var title = this.refs.title.getDOMNode().value.trim();
            var description = this.refs.description.getDOMNode().value.trim();
            var location = this.refs.location.getDOMNode().value.trim();
            console.log("title=" + title);
            console.log("location=" + location);
            console.log("description=" + description);
        }              
    }
    );