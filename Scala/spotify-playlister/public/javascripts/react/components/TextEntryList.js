var TextEntry = React.createClass({

  componentDidMount : function() {
    console.log("text mounted")
    this.refs.textEntry.value = "I AM The EGG MAN"
  },

  keyHasBeenPressed : function(e) {
      if (e.keyCode == 13) {
        var textEntry = this.refs.textEntry.value;
        this.props.appendEntry(textEntry);           
      }      
  },

  editHasHappened : function(e) {
      // TODO
  },

  render: function() {
    console.log("default value is: " + this.props.defaultValue)
    return (
      <div onBlur={this.editHasHappened} onKeyDown={this.keyHasBeenPressed} className="textEntry">
        <input className="textEntry" type="text" autoComplete="off" defaultValue={this.props.defaultValue} placeholder={this.props.placeholder} ref="textEntry"/>          
      </div>
    );
  }
});

var PreviousTextEntries = React.createClass({
  componentDidMount: function() {console.log("Previous text entries mounted")},

  render: function() {
      var textEntryNodes = this.props.data.map(function (textEntry) {
      console.log("Rendering previous entry " + JSON.stringify(textEntry))
      return (
        <TextEntry defaultValue={textEntry.value} key={textEntry.id}>
        </TextEntry>
      );
    });
    return (
      <div className="PreviousTextEntries">
        {textEntryNodes}
      </div>
    );
  }
});

// var TextEntryForm = React.createClass({
//   handleSubmit: function(e) {
//     e.preventDefault();
//     var entry = this.refs.entry.value.trim();
//     if (!entry) {
//       return;
//     }
//     this.props.onTextEntrySubmit({entry: entry});
//     this.refs.entry.value = '';    
//     return;
//   },
//   render: function() {
//     return (
//       <form className="textEntryForm" onSubmit={this.handleSubmit}>
//         <input type="text" placeholder="Artist" ref="entry" />        
//       </form>
//     );
//   }
// });

var TextEntryBox = React.createClass({
  render: function() {
    return (
      <div className="textEntryBox">
        <h1>Artists</h1>
        <PreviousTextEntries appendEntry={this.props.appendEntry} data={this.props.data} />
        <TextEntry appendEntry={this.props.appendEntry} placeholder="Artist..." defaultValue="oogabooga" />
      </div>
    );
  }
});

var PlayListSubmitter = React.createClass({
  appendEntry: function(textEntry) {

    console.log("handling text entry submit FOR " + JSON.stringify(textEntry));
    var textEntries = this.state.data;
    var newTextEntrys = textEntries.concat([{id : this.state.children++, value: textEntry}]);
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
        <TextEntryBox appendEntry={this.appendEntry} data={this.state.data}/>
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
    console.log(Object.keys(textEntry))
    return textEntry.entry;
}