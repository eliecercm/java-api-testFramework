import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.*;

/**
 * This is my Test class which extends from the GetRequestBuilder.class in order to perform the different tests with
 * different data sets.
 * I'm using TestNG as the TestRunner.
 * @Author Eliecer Cordero
 * */

public class GetRequestsTestSuite extends GetRequestsBuilder {

    final static String APIKEY = "DEMO_KEY";
    final static String SOL = "1000";
    final static String EARTH_DATE = "2015-05-30";
    final static String CURIOSITYROVER = "curiosity";
    final static String OPPORTUNITYROVER = "Opportunity";

    List<Object> first10MarsPhotosByCuriosityOn1000MartianSol;
    List<Object> first10MarsPhotosByCuriosityOnEarthDateEqualsTo1000MartianSol;

    @Test(description = "This test case verifies that only the first 10 Mars photos by Curiosity Rover are gotten and" +
            "they match the Mars Sol number provided.")
    public void getTheFirst10MarsPhotosByCuriosityOn1000MartianSol() {
        first10MarsPhotosByCuriosityOn1000MartianSol =
                getMarsPhotosRequestsBuilderForNASARover(APIKEY,SOL,CURIOSITYROVER).subList(0,10);

        assertEquals(first10MarsPhotosByCuriosityOn1000MartianSol.size(),10, "There are more than 10 photos. Please check.");
        for(int i = 0; i <= 9; i++){
            String photo = first10MarsPhotosByCuriosityOn1000MartianSol.get(i).toString();
            assertTrue(photo.contains("sol=1000"), "One or more photos was taken in a different MARS Day. Please check.");
        }
    }

    @Test(description = "This test case verifies that only the first 10 Mars photos by Curiosity Rover are gotten and" +
            "they match the Mars Sol number date on earth.", priority = 1)
    public void getTheFirst10MarsPhotosByCuriosityOnEarthDateEqualsTo1000MartianSol(){
        first10MarsPhotosByCuriosityOnEarthDateEqualsTo1000MartianSol =
                getMarsPhotosRequestsBuilderForNASARover(APIKEY,EARTH_DATE,CURIOSITYROVER).subList(0,10);

        assertEquals(first10MarsPhotosByCuriosityOnEarthDateEqualsTo1000MartianSol.size(),10,
                "There are more than 10 photos. Please check.");
        for(int i = 0; i<=9; i++){
            String photo = first10MarsPhotosByCuriosityOnEarthDateEqualsTo1000MartianSol.get(i).toString();
            assertTrue(photo.contains("sol=1000") && photo.contains("earth_date=2015-05-30") ,
                    "One or more photos was taken in a different MARS Day. Please check.");
        }
    }

    @Test(description = "This test case verifies that the first 10 Mars photos by Curiosity on 1000 Mars Sol are the" +
            "same first 10 Mars photos taken on the 100 Mars Sol date on earth.", priority = 3)
    public void comparingFirst10MarsPhotosByCuriosityOn1000MartianSolAgainstFirst10OnEarthDateEqualsTo1000MartianSol(){
        assertEquals(first10MarsPhotosByCuriosityOn1000MartianSol,first10MarsPhotosByCuriosityOnEarthDateEqualsTo1000MartianSol,
                "The photos taken in Mars Sol 1000 do not match with the ones taken in the Earth Day. Please Check." );
    }

    @Test(description = "This test case verifies that the amount of the Mars photos taken by the Curiosity' cameras are not" +
            "10 times greater than the Mars photos' amount taken by other cameras.", priority = 4)
    public void curiosityCamerasPictureAmountIsNot10TimesGreaterThanOtherCameras(){
        int curiosityCamerasPicturesAmount = getMarsPhotosRequestsBuilderForNASARover(APIKEY,EARTH_DATE,CURIOSITYROVER).size();
        int opportunityCamerasPicturesAmount = getMarsPhotosRequestsBuilderForNASARover(APIKEY,EARTH_DATE,OPPORTUNITYROVER).size();

        assertTrue((curiosityCamerasPicturesAmount /opportunityCamerasPicturesAmount) < 10,
                "The Curiosity's cameras has taken photos more than 10 times than other cameras. Please Check.");
    }
}
