package edu.regis.msse670.model.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import edu.regis.msse670.model.services.factory.ServiceFactoryTest;
import edu.regis.msse670.model.services.inventoryservice.InventoryServicesImplTest;
import edu.regis.msse670.model.services.worldinventoryservice.WorldInventoryServicesImplTest;


@RunWith(Suite.class)
@SuiteClasses({ InventoryServicesImplTest.class, ServiceFactoryTest.class, WorldInventoryServicesImplTest.class })
public class AllServicesTests {

}
