var TextEntry = React.createClass({

  componentDidMount: function() {console.log("Text entry mounted")},

  keyHasBeenPressed : function(e) {
      if (e.keyCode == 13) {
          this.props.handleEdit({entry: "TODO get this elements value"});
      }      
  },

  editHasHappened : function(e) {
      console.log("attempt to get value " + this.refs);

      this.props.handleEdit({entry: "TODO get this elements value"});   
  },

  render: function() {
    return (
      <div onBlur={this.editHasHappened} onKeyDown={this.keyHasBeenPressed} className="textEntry">
        <input defaultValue={this.props.entry}></input>          
          {this.props.children}
      </div>
    );
  }
});

var PreviousTextEntries = React.createClass({
    componentDidMount: function() {console.log("Previous text entries mounted")},


  render: function() {
    var handleEdit = this.props.handleEdit;
    var textEntryNodes = this.props.data.map(function (textEntry) {
      return (
        <TextEntry handleEdit={handleEdit} entry={textEntry.entry}>
          {textEntry.text}
        </TextEntry>
      );
    });
    return (
      <div className="textEntrylist">
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
        <PreviousTextEntries handleEdit={this.props.handleTextEntryEdit} data={this.props.data} />
        <TextEntry handleEdit={this.props.handleTextEntryEdit} />
      </div>
    );
  }
});

var PlayListSubmitter = React.createClass({
  handleTextEntryEdit: function(textEntry) {
    console.log("handling text entry submit")
    var textEntries = this.state.data;
    var newTextEntrys = textEntries.concat([textEntry]);
    this.setState({data: newTextEntrys});     
  },

  getInitialState: function() {
    return {data: []};
  },

  getPlaylist : function() {
    
    console.log("Sending: " + this.toJson())
  },

  render: function() {
    return (
      <div className="textEntryBox">
        <TextEntryBox handleTextEntryEdit={this.handleTextEntryEdit} data={this.state.data}/>
        <button onClick={this.getPlaylist} className="btn btn-primary btn-lg">Get Top Tracks! &raquo;</button>
      </div>
    );
  },

  toJson : function() {
    var stringArray = this.state.data.map(getTextEntryValues)
    return stringArray;
   }
});

ReactDOM.render(
  <PlayListSubmitter />,
  document.getElementById('artistList')
);

function getTextEntryValues(textEntry) {
    return textEntry.entry;
}