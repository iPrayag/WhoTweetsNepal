package whotweetsnepal

class Post {
    String username;
    String status;
    Date created = new Date();
    static mapWith="mongo"
    static constraints = {
        created(display:false)
    }
}
