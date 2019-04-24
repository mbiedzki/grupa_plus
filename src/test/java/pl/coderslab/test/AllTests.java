package pl.coderslab.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.coderslab.test.Service.CompanyServiceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ CompanyServiceTest.class})
public class AllTests {
}
