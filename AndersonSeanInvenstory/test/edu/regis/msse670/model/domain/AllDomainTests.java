package edu.regis.msse670.model.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BasicInventoryTest.class, DataSphereTest.class, WorldInventoryTest.class,
	InventoryItemTest.class, InventoryMoteTest.class, InventoryRegionTest.class })
public class AllDomainTests {

}
