var Event = React.createClass({
    render: function() {
        return (
            <li className="event">
              <a>{this.props.title}</a>
              <p>href={"events/" + this.props.idNum}</p>
            </li>
        );
        }
});

var EventList = React.createClass({

  getInitialState: function() {
      return {data: []};
  },

  componentDidMount: function() {
      console.log("calling componentDidMount");
      $.ajax({
          url: this.props.url,
          dataType: 'json',
          success: function(data) {
            this.setState({data: data})
          }.bind(this)
      });
  },

  render: function() {
    var eventNodes = this.state.data.map(function(event) {return (<Event title={event.title} idNum={event.id}/>)});
        return (
            <div className="eventList">
              {eventNodes}
            </div>
  )}
});     
