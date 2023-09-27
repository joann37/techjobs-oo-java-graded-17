package org.launchcode.techjobs.oo;

import org.junit.Test;

import javax.xml.namespace.QName;

import static org.testng.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId() {
        Job blankJob1 = new Job();
        Job blankJob2 = new Job();
        assertNotEquals(blankJob1, blankJob2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testAJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testAJob instanceof Job);

        assertTrue(testAJob.getName()=="Product tester");

        assertTrue(testAJob.getEmployer() instanceof Employer);
        assertTrue(testAJob.getEmployer().getValue() =="ACME");

        assertTrue(testAJob.getLocation() instanceof Location);
        assertTrue(testAJob.getLocation().getValue() =="Desert");

        assertTrue(testAJob.getPositionType() instanceof PositionType);
        assertTrue(testAJob.getPositionType().getValue() =="Quality control");

        assertTrue(testAJob.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(testAJob.getCoreCompetency().getValue() =="Persistence");

    }
    @Test
    public void testJobsForEquality(){

        Job oneJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("persistence"));
        Job twoJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(oneJob.equals(twoJob));
    }

}
