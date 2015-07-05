package main 

import (
    "log"
    "net/http"
    "fmt"
    "os"
    "encoding/json"
    "io"
    "github.com/ipolding/eventserver"

)
 
func main() {
    // your http.Handle calls here
    log.SetFlags(log.Llongfile)
    eventserver.DbInit("/home/ian/dev/Projects/public-bubble/database/test.db")
    http.Handle("/healthcheck", http.HandlerFunc(healthCheck))
    http.Handle("/kill", http.HandlerFunc(kill))
    http.Handle("/events", http.HandlerFunc(EventsHandler))
    log.Fatal(http.ListenAndServe("localhost:4000", nil))
    log.Println("Server started!")
}
 
func kill(w http.ResponseWriter, r *http.Request) {
    fmt.Fprint(w, "Thus I die.")
    os.Exit(0)
}

func EventsHandler(w http.ResponseWriter, r *http.Request) {
    request_method := r.Method
    switch request_method {
        case "POST":
            var body io.ReadCloser = r.Body
            dec := json.NewDecoder(body)
            for {
                    var event eventserver.Event
                    if err := dec.Decode(&event); err == io.EOF {
                                    break
                     } else if err != nil {
                         log.Fatal(err)
                         http.Error(w, "Error reading request", http.StatusTeapot)
                     }
            eventserver.PersistEvent(event)         
            } 
        
        default: 
            log.Println("Request method " + request_method)
            http.Error(w, "Unsupported method", http.StatusNotImplemented)    
    }
    }

func healthCheck(w http.ResponseWriter, r *http.Request) {
    fmt.Fprint(w, "All healthy and happy here!")
}
