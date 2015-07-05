package eventserver
 
import (
    "log"
    "database/sql"
    _ "github.com/lib/pq"
    )

var dataSourceName string
var DB_DRIVER string

func DbInit(dbLocation string) {
    dataSourceName = dbLocation
    
    }

func PersistEvent(event Event) {

        db, err := sql.Open("postgres", dataSourceName)
        log.Print(dataSourceName)
        tx, err := db.Begin()
        if err != nil {
            log.Fatal(err)
        }
         
         insert_event, err := db.Prepare("INSERT INTO events(title, location, description) values ($1, $2, $3)")
         if err != nil {
              log.SetFlags(log.Llongfile)
              log.Fatal(err)
         }        

        _, err = insert_event.Exec(event.Title, event.Location, event.Description,)

        if err != nil {
              log.SetFlags(log.Llongfile)
              log.Fatal(err)
               }
        tx.Commit()
// close the DB?
    }
