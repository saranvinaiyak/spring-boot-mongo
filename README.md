### Mongo Demo

You can run this app using the following command.
`gradlew bootrun` 

For powershell users please run `.\gradlew bootrun`

As a prerequisite, make sure mongodb is installed and do not set any password.

Following is the APIs and sample requests

#### Add Student
> URL: http://localhost:8080/add/student
>
>Method: `POST`
>
>Sample Input:
> ```
> {
>   "studentName" : "stud20",
>   "rollNo" : "10",
>   "dateOfBirth":"123425344545",
>   "branch":"EE",
>   "section":"C",
>   "year":2019
> }
> ```


#### Display all students
> URL: http://localhost:8080/display/students
>
> Method: `GET`


#### Delete Student
> URL: http://localhost:8080/delete/student?id=60a733fcbf25843c9482c2a9
>
> Method: `DELETE`
>
> Request Param: id (id of the document in mongo db)
