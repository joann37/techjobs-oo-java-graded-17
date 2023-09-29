package org.launchcode.techjobs.oo;
import org.junit.Before;
import org.junit.Test;
import javax.xml.namespace.QName;
import static java.lang.System.lineSeparator;
import static org.testng.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    public Job testAJob1;
    public Job testAJob2;

    @Before
    public void initialize(){
         testAJob1 = new Job();
         testAJob2 = new Job();
    }
    @Test
    public void testSettingJobId() {
        assertNotEquals(testAJob1.getId(), testAJob2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testAJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testAJob instanceof Job);


        assertEquals("Product tester", testAJob.getName());

        assertTrue(testAJob.getEmployer() instanceof Employer);
        assertEquals("ACME", testAJob.getEmployer().toString());

        assertTrue(testAJob.getLocation() instanceof Location);
        assertEquals("Desert", testAJob.getLocation().toString());

        assertTrue(testAJob.getPositionType() instanceof PositionType);
        assertEquals("Quality control", testAJob.getPositionType().toString());

        assertTrue(testAJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", testAJob.getCoreCompetency().toString());

    }
    @Test
    public void testJobsForEquality(){

        Job testAJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("persistence"));
        Job testAJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(testAJob1.equals(testAJob2));
    }
@Test
    public void testToStringStartsAndEndsWithNewLine(){

        Job testerJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
       // int finalIndex = (testerJob.toString().length()-1);
        String firstChar = String.valueOf(testerJob.toString().charAt(0));
        String lastChar = String.valueOf(testerJob.toString().charAt(testerJob.toString().length()-1));
        assertEquals(firstChar, "\n");
        assertEquals(lastChar, "\n");
    }

@Test
    public void testToStringContainsCorrectLabelAndData(){
        Job testAJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("\nID: " + testAJob.getId() + "\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n", testAJob.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job testAJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType(""), new CoreCompetency(""));
        String expected = "\nID: 10\nName: Product tester\nEmployer: ACME\nLocation: Desert" + "\nPosition Type: Data not available\nCore Competency: Data not available\n";
        assertEquals(expected, testAJob3.toString());

    }
}
