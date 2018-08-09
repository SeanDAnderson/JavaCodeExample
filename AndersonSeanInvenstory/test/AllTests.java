import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import edu.regis.msse670.invenstory.business.AllBusinessTests;
import edu.regis.msse670.invenstory.domain.AllDomainTests;
import edu.regis.msse670.invenstory.services.AllServicesTests;

@RunWith(Suite.class)
@SuiteClasses({AllBusinessTests.class, AllDomainTests.class, AllServicesTests.class})
public class AllTests {

}
