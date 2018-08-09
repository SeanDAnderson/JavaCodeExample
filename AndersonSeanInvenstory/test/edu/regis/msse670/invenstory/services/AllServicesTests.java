package edu.regis.msse670.invenstory.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import edu.regis.msse670.invenstory.services.factory.*;
import edu.regis.msse670.invenstory.services.inventoryservice.*;
import edu.regis.msse670.invenstory.services.worldinventoryservice.*;

@RunWith(Suite.class)
@SuiteClasses({ InventoryServicesImplTest.class, ServiceFactoryTest.class, WorldInventoryServicesImplTest.class })
public class AllServicesTests {

}
