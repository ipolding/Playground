var TextEntry = React.createClass({
  render: function() {
    return (
      <div onChange={this.props.entryEdited} className="textEntry">
        <input defaultValue={this.props.entry}></input>          
          {this.props.children}
      </div>
    );
  }
});

var PreviousTextEntries = React.createClass({
  render: function() {
    var textEntryNodes = this.props.data.map(function (textEntry) {
      return (
        <TextEntry entry={textEntry.entry}>
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

var TextEntryForm = React.createClass({
  handleSubmit: function(e) {
    e.preventDefault();
    var entry = this.refs.entry.value.trim();
    if (!entry) {
      return;
    }
    this.props.onTextEntrySubmit({entry: entry});
    this.refs.entry.value = '';    
    return;
  },
  render: function() {
    return (
      <form className="textEntryForm" onSubmit={this.handleSubmit}>
        <input type="text" placeholder="Artist" ref="entry" />        
      </form>
    );
  }
});

var TextEntryBox = React.createClass({
  render: function() {
    return (
      <div className="textEntryBox">
        <h1>Artists</h1>
        <PreviousTextEntries data={this.props.data} />
        <TextEntryForm onTextEntrySubmit={this.props.handleTextEntrySubmit} />
      </div>
    );
  }
});

var PlayListSubmitter = React.createClass({
  handleTextEntrySubmit: function(textEntry) {
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
        <TextEntryBox handleTextEntrySubmit={this.handleTextEntrySubmit} data={this.state.data}/>
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