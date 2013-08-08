package openshift;




import java.util.logging.Level;
import java.util.logging.Logger;
//import org.jboss.tools.openshift.express.client.*;
//import org.jboss.tools.openshift.express.client.User;
import com.openshift.client.*;
import com.openshift.client.IUser;
/**
 *
 * @author jled
 */
public class OpenshiftCredentials {
    private IUser user;
    private ISSHPublicKey sshKey;

    /**
     * @return the user
     */

    public IUser getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(IUser user) {
        this.user = user;
    }

    /**
     * @return the sshKey
     */
    public ISSHPublicKey getSshKey() {
        return sshKey;
    }

    /**
     * @param sshKey the sshKey to set
     */
    public void setSshKey(ISSHPublicKey sshKey) {
        this.sshKey = sshKey;
    }

}
