
var EventsBox = React.createClass({
    render: function(){

        return(<div className="eventBox">
                    I am an event box and I have an events list
                    <EventList url={this.props.url} />
                    and an events form:
                    <EventForm url={this.props.url}/>
               </div>);
    }
});

React.render(
    <EventsBox url="events.json"/>,
    document.getElementById('eventsBox')
);