import com.zazzercode.whotweetsnepal.User
class BootStrap {

    def init = { servletContext ->
          def admin=User.findByUsername("admin")?:
                new User(username:"admin", password:"admin", enabled:true, accountLocked:false,accountExpired:false, passwordExpired:false).save(flush:true)
          if(admin.hasErrors()){
                  admin.errors.each{println it}
          }     
    }
    def destroy = {
    }
}
