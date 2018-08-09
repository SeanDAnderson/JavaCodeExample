import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import edu.regis.msse670.model.business.AllBusinessTests;
import edu.regis.msse670.model.domain.AllDomainTests;
import edu.regis.msse670.model.services.AllServicesTests;



@RunWith(Suite.class)
@SuiteClasses({AllBusinessTests.class, AllDomainTests.class, AllServicesTests.class})
public class AllTests {

}
