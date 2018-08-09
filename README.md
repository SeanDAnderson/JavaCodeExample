# JavaCodeExample InvenStory

This is an example of my Java coursework from my Master of Science in Software Engineering at Regis University.

It is an attempt to build a core management system for a large RPG engine.
The intention was that all items in the game (the world, regions, locations, objects, NPCs and gear) could be inventories 
with 'motes' stored within them to establish their properties.

For example a sword would have 'weapon', 'one handed', and 'piercing' motes, as well as a 'minimum damage' container holding
a '2' mote and a 'Maximum damage' container holding an '8' mote. The result would be a one-handed, piercing sword that does between 2 and 8 damage.

The format proved too cumbersome and the resource consumption was much too high to compensate for any benefit so the 
experiement wasn't continued after the class finished.

The current build allows you to create a World Inventory (the largest inventory category) and fill it with sub-inventories and motes, as well as saving the world inventory (I do not remember why loading the inventory is not a part of the build for the class). The course concluded before other inventory management systems were added. 
