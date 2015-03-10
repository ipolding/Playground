package main
 
import (
    "log"
    "net/http"
    "fmt"
    "os"
    "encoding/json"
    "io"
)
 
type Event struct {
    Title string `json:"title"`
    Location string `json:"location"`
    Description string `json:"description"`
}
 
func main() {
    // your http.Handle calls here
    http.Handle("/kill", http.HandlerFunc(kill))
    http.Handle("/events", http.HandlerFunc(EventsHandler))
    log.Fatal(http.ListenAndServe("localhost:4001", nil))
}
 
func kill(w http.ResponseWriter, r *http.Request) {
    fmt.Fprint(w, "Thus I die.")
    os.Exit(0)
}

var events_slice []Event = make([]Event, 1)

func EventsHandler(w http.ResponseWriter, r *http.Request) {
    request_method := r.Method
    switch request_method {
        case "POST":
            var body io.ReadCloser = r.Body
            dec := json.NewDecoder(body)
            for {
                    var event Event
                    if err := dec.Decode(&event); err == io.EOF {
                                    break
                     } else if err != nil {
                         log.Fatal(err)
                     }
                     fmt.Printf("%s at %s\n about %s", event.Title, event.Location, event.Description) }
        case "GET": 
            test_event := Event{"Test Title", "Test Location", "Test Description"}
            events_slice = append(events_slice, test_event)   
            result, err := json.Marshal(events_slice)
                if (err != nil) {
                    http.Error(w, "Unsupported method", http.StatusInternalServerError)       
                }
            w.Header().Set("Content-Type", "application/json")
            w.Write(result)
        default: http.Error(w, "Unsupported method", http.StatusNotImplemented)    
    }
    }