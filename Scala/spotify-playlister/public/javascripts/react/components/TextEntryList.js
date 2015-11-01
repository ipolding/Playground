var TextEntry = React.createClass({

  getInitialState: function() {
    return {text: ''};
  },

  handleChange : function(e) {
    this.setState(
      {
        id : this.props.key,
        text : e.target.value}
      );
  },

  edit: function(event) {
     this.props.editEntry(0, this.state.text)
   },

  keyHasBeenPressed : function(e) {
      if (e.keyCode == 13) {
        var textEntry = this.refs.textEntry.value;
        this.props.appendEntry(textEntry);
               
      }      
  },

  render: function() {
     var message = this.state.message;
    console.log("default value is: " + this.props.defaultValue)
    return (
      <div onBlur={this.edit} onChange={this.handleChange} onKeyDown={this.keyHasBeenPressed}>
        <input placeholder={this.props.placeholder} value={this.state.text} className="textEntry" ref="textEntry"/>          
      </div>
    );
  }
});

var PreviousTextEntries = React.createClass({
  componentDidMount: function() {console.log("Previous text entries mounted")},

  render: function() {
      var editEntry = this.props.editEntry;
      var appendEntry = this.props.appendEntry;
      var textEntryNodes = this.props.data.map(function (textEntry) {
      console.log("Rendering previous entry " + JSON.stringify(textEntry))
      return (
        <TextEntry placeholder="Artist..." value={textEntry.value} key={textEntry.id} appendEntry={appendEntry} editEntry={editEntry}/>
      );
    });
    return (
      <div className="PreviousTextEntries">
        {textEntryNodes}
      </div>
    );
  }});

var TextEntryBox = React.createClass({
  render: function() {
    return (
      <div className="textEntryBox">
        <h1>Artists</h1>
        <PreviousTextEntries editEntry={this.props.editEntry} appendEntry={this.props.appendEntry} data={this.props.data} />
        <div>
             <TextEntry editEntry={this.props.editEntry} appendEntry={this.props.appendEntry} data={this.props.data} defaultValue="" placeholder="Artist..." />
        </div>
      </div>
    );
  }
});

var PlayListSubmitter = React.createClass({


  editEntry: function(id, value) {
     console.log("EDIT ENTRY FUNCTION CALLED WITH id: " + id + ", value: " + value)

      var modifiedArray = this.state.data;
      modifiedArray[id] = value
      this.setState({
      children: this.state.children++,
      data: modifiedArray
    });  
  },

  appendEntry: function(text) {

    console.log("handling text entry submit FOR " + JSON.stringify(text));
    var textEntries = this.state.data;
    var newTextEntrys = textEntries.concat([{id : this.state.children++, value: text}]);
    this.setState({
      children: this.state.children++,
      data: newTextEntrys
    });

  },

  getInitialState: function() {
    return {
      children : 0,
      data: []};
  },

  getPlaylist : function() {
    
    console.log("Sending: " + this.toJson())
  },

  render: function() {
    return (
      <div className="textEntryBox">
        <TextEntryBox editEntry={this.editEntry} appendEntry={this.appendEntry} data={this.state.data}/>
        <button onClick={this.getPlaylist} className="btn btn-primary btn-lg">Get Top Tracks! &raquo;</button>
      </div>
    );
  },

  toJson : function() {
    console.log(this.state.data)
    var stringArray = this.state.data.map(getTextEntryValues)
    return stringArray;
   }
});

ReactDOM.render(
  <PlayListSubmitter />,
  document.getElementById('artistList')
);

function getTextEntryValues(textEntry) {
    return textEntry.value;
}