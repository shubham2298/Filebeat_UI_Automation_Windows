package StepDefinition

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import org.codehaus.plexus.archiver.tar.TarGZipUnArchiver
import org.codehaus.plexus.logging.console.ConsoleLoggerManager
import org.openqa.selenium.chrome.ChromeDriver

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver

import org.junit.Assert

import java.io.BufferedReader;
import java.io.IOException
import java.nio.file.FileVisitResult;
import java.nio.file.Files
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.FileVisitResult
import java.nio.file.Path
import java.nio.file.SimpleFileVisitor
import java.nio.file.attribute.BasicFileAttributes
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream
import java.util.concurrent.TimeUnit
import org.openqa.selenium.By;
class filebeat {

    @Given('^user is already Download  FileBeat Zip$')
    void user_is_already_Download_FileBeat_Zip() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then('^Perform Extract ZIP File$')
    void perform_Extract_ZIP_File() throws Throwable {

        String pathToUpdateZip = 'C:\\SETUP\\filebeat-7.5.1-windows-x86_64.zip'
        String destinationPath = 'C:\\SETUP\\Assignment'
        byte[] byteBuffer = new byte[1024]

        try{
            ZipInputStream inZip = new ZipInputStream(new FileInputStream(pathToUpdateZip))
            ZipEntry inZipEntry = inZip.getNextEntry()
            while(inZipEntry != null){
                String fileName = inZipEntry.getName()
                File unZippedFile = new File(destinationPath + File.separator + fileName)
             //   println("Unzipping: " + unZippedFile.getAbsoluteFile())
                if (inZipEntry.isDirectory()){
                    unZippedFile.mkdirs()
                }else{
                    new File(unZippedFile.getParent()).mkdirs()
                    unZippedFile.createNewFile()
                    FileOutputStream unZippedFileOutputStream = new FileOutputStream(unZippedFile)
                    int length
                    while((length = inZip.read(byteBuffer)) > 0){
                        unZippedFileOutputStream.write(byteBuffer,0,length)
                    }
                    unZippedFileOutputStream.close()
                }
                inZipEntry = inZip.getNextEntry()
            }
            inZip.close()
        //    println("Finished Unzipping")
        }catch(IOException e){
            e.printStackTrace()
        //    println("Something Wrong")
        }


    }

    @Then('^Read Filebeat\\.yaml and make changes$')
    void read_Filebeat_yaml_and_make_changes() throws Throwable {

        //Instantiating the File class
        String filePath = "C:\\SETUP\\Assignment\\filebeat-7.5.1-windows-x86_64\\filebeat.yml"
        //Instantiating the Scanner class to read the file
        sleep(4000)
        Scanner sc = new Scanner(new File(filePath))
        //instantiating the StringBuffer class
        StringBuffer buffer = new StringBuffer()
        //Reading lines of the file and appending them to StringBuffer
        while (sc.hasNextLine()) {
            buffer.append(sc.nextLine()+System.lineSeparator())
        }
        String fileContents = buffer.toString()
        // System.out.println("Contents of the file: "+fileContents);
        //closing the Scanner object
        sc.close()
        //String oldLine = "/var/log/*.log";
        //String newLine = "/home/gslab/Desktop/security/FileBeat/filebeat-7.5.1-linux-x86_64/log/sample.log";

        fileContents = fileContents.replaceFirst("    - /var/log/*.","    - C:\\\\Users\\\\GS-2397\\\\Documents\\\\sample")

        //Replacing the old line with new line
        fileContents = fileContents.replaceFirst("  enabled: false", "  enabled: true")
        //instantiating the FileWriter class
        FileWriter writer = new FileWriter(filePath)
        //System.out.println("")
        //System.out.println("new data: "+fileContents)
        writer.append(fileContents)
        writer.flush()
        writer.close();

    }

    @Then('^Execute Filebeat\\.sh file and run Filebeat\\.yaml file$')
    void execute_Filebeat_sh_file_and_run_Filebeat_yaml_file() throws Throwable {




        try {
            Runtime.getRuntime().exec(
                    "cmd /c start cmd.exe /K \"cd C:\\\\SETUP\\\\Assignment\\\\filebeat-7.5.1-windows-x86_64 && filebeat.exe\"")
            Thread.sleep(10000)
            Runtime.getRuntime().exec("taskkill /f /im filebeat.exe")
            Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
        } catch (Exception e) {
            System.out.println("Something Wrong ")
            e.printStackTrace()
        }

//
//        Runtime.getRuntime().exec(
//                "cmd /c start cmd.exe /K \"cd C:\\SETUP\\Assignment\\filebeat-7.5.1-windows-x86_64 && filebeat.exe\"")
//
//
//
//
////        ProcessBuilder pb = new ProcessBuilder("C:\\SETUP\\Assignment\\filebeat-7.5.1-windows-x86_64\\filebeat.exe", "-c", "C:\\SETUP\\Assignment\\filebeat-7.5.1-windows-x86_64\\filebeat.yml", "-e")
////        pb.redirectErrorStream(true)
////        Process p = pb.start()
//       sleep(20000)
//
//        try {
//           // Runtime.getRuntime().exec("taskkill /f /im filebeat.yml")
//            Runtime.getRuntime().exec("taskkill  /f /im filebeat.exe")
//
//            Runtime.getRuntime().exec("taskkill /f /im cmd.exe")
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

       // p.destroy()


    }
WebDriver driver;
    @Given('^user is already on Kibana page$')
    void user_is_already_on_Kibana_page() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\GS-2397\\Documents\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("http://localhost:5601/app/kibana#/management/kibana/index_patterns?_g=(refreshInterval:(pause:!t,value:0),time:(from:now-7d,to:now))");
        // driver.manage().timeouts().implicitlyWait(14,TimeUnit.SECONDS) ;
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //aa
        driver.findElement(By.xpath("//button[@data-test-subj=\"euiFlyoutCloseButton\"]")).click();
    }

    @Then('^Index Created$')
    void index_Created() throws Throwable {
        driver.findElement((By.xpath("//button[@data-test-subj=\"createIndexPatternButton\"]"))).click();
        //  Thread.sleep(2000);



        driver.findElement(By.xpath("//input[@name=\"indexPattern\"]")).sendKeys("fil");

    }

    @Then('^Verify Index Created and Click on Create Index$')
    void verify_Index_Created_and_Click_on_Create_Index() throws Throwable {
        String data=driver.findElement(By.xpath("//*[@id=\"createIndexPatternReact\"]/div[1]/div[2]/div[3]/span/span/strong[1]")).getText();
        Assert.assertEquals("Success!",data);
        driver.findElement(By.xpath("//button[@data-test-subj=\"createIndexPatternGoToStep2Button\"]")).click();
        //  Thread.sleep(1000);
        driver.findElement(By.xpath("//select[@name=\"timeField\"]")).click();
        //  Thread.sleep(1000);
        driver.findElement(By.xpath("//option[@value=\"@timestamp\"]")).click();
        //  Thread.sleep(1000)
        driver.findElement(By.xpath("//button[@data-test-subj=\"createIndexPatternButton\"]")).click();
        // Thread.sleep(3000)
        driver.findElement(By.xpath("//button[@tooltip=\"Set as default index\"]")).click();

    }

    @Then('^Search Log on Kibana$')
    void search_Log_on_Kibana() throws Throwable {
        driver.get("http://localhost:5601/app/kibana#/discover?_g=(refreshInterval:(pause:!t,value:0),time:(from:now-7d,to:now))&_a=(columns:!(_source),index:'5355c360-2d29-11ea-820d-9b22843eac32',interval:auto,query:(language:kuery,query:''),sort:!(!('@timestamp',desc)))");
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder=\"Search\"]")).sendKeys("1991304703");
        // driver.sleep(2000);
        driver.findElement(By.xpath("//button[@data-test-subj=\"querySubmitButton\"]")).click();

    }

    @Then('^search Invalid log on Kibana gives Negative Results$')
    void search_Invalid_log_on_Kibana_gives_Negative_Results() throws Throwable {
        driver.get("http://localhost:5601/app/kibana#/discover?_g=(refreshInterval:(pause:!t,value:0),time:(from:now-7d,to:now))&_a=(columns:!(_source),index:'5355c360-2d29-11ea-820d-9b22843eac32',interval:auto,query:(language:kuery,query:''),sort:!(!('@timestamp',desc)))");
        driver.findElement(By.xpath("//input[@placeholder=\"Search\"]")).sendKeys("shubham");
        driver.findElement(By.xpath("//button[@data-test-subj=\"querySubmitButton\"]")).click();
        //CHECKING
        Thread.sleep(1000);
        WebElement d1=driver.findElement(By.xpath("//span[@class=\"euiCallOutHeader__title\"]"));

        //
        System.out.println("svdsa"+d1.getText());
        //  println("TEXT1"+d1.getText());
        ////span[@class="euiCallOutHeader__title"]
        Assert.assertEquals(d1.getText(),"No results match your search criteria")

    }

    @Given('^when user is on already created Index and Index Pattern and user is on that Page$')
    void when_user_is_on_already_created_Index_and_Index_Pattern_and_user_is_on_that_Page() throws Throwable {

        driver.get("http://localhost:5601/app/kibana#/management/kibana/index_patterns?_g=(refreshInterval:(pause:!t,value:0),time:(from:now-7d,to:now))");
        System.out.println("wqertyuiop")
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Then('^delete index and Index Pattern$')
    void delete_index_and_Index_Pattern() throws Throwable {

        driver.findElement(By.xpath("//a[@class=\"euiButtonEmpty euiButtonEmpty--primary euiButtonEmpty--xSmall\"]")).click();
        driver.findElement(By.xpath("//span[@class=\"kuiIcon fa-trash\"]")).click();
        driver.findElement((By.xpath("//button[@class=\"euiButton euiButton--primary euiButton--fill\"]"))).click();


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Thread.sleep(2000);
        driver.get("http://localhost:5601/app/kibana#/management/elasticsearch/index_management/indices?_g=()");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@class=\"euiCheckbox__input\"]")).click();
        driver.findElement(By.xpath("//button[@class=\"euiButton euiButton--primary euiButton--iconRight euiButton--fill\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"kibana-app\"]/div[4]/div/div[3]/div/div[2]/div/div/div[2]/div/button[11]")).click();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id=\"kibana-app\"]/div[4]/div[3]/div/div/div[3]/button[2]")).click();



    }

    @Then('^Delete FileBeat Directory$')
    void delete_FileBeat_Directory() throws Throwable {




        Path directory = Paths.get("C:\\SETUP\\Assignment\\filebeat-7.5.1-windows-x86_64");
        Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) throws IOException {
                Files.delete(file); // this will work because it's always a File
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir); //this will work because Files in the directory are already deleted
                return FileVisitResult.CONTINUE;
            }
        });


    }


}
