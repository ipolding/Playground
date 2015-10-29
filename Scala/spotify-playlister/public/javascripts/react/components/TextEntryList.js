var TextEntry = React.createClass({
  render: function() {
    return (
      <div className="textEntry">
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
  handleTextEntrySubmit: function(textEntry) {
    var textEntries = this.state.data;
    var newTextEntrys = textEntries.concat([textEntry]);
    this.setState({data: newTextEntrys});
    this.toJson();
  },
  getInitialState: function() {
    return {data: []};
  },
  render: function() {
    return (
      <div className="textEntryBox">
        <h1>Artists</h1>
        <PreviousTextEntries data={this.state.data} />
        <TextEntryForm onTextEntrySubmit={this.handleTextEntrySubmit} />
      </div>
    );
  },

  toJson : function() {
    this.state.data.forEach(
      function(datum) {
        console.log(datum);
      }); 
   }
});

ReactDOM.render(
  <TextEntryBox />,
  document.getElementById('artistList')
);