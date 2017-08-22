package com.generator.generators;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class TestCaseGenerator {

    private String TestCaseName = "TC_UI_EM_01_001";

    public void fire(){}
    public void generateTestCase() {

    }
    public void getTemplate(){
    }

    public void gege(String TestCase, String TestSuite, String TestFunction) throws IOException {
        String src = this.getApplicationDir() + "/src/main/java/com/generator/templates/TestCaseTemplate.stub";
        String dst = this.getApplicationDir() + "/src/main/java/com/generator/test_suites/"+TestCase+".java";
        File file = new File(src);
        String content = FileUtils.readFileToString(file, "UTF-8");
        content = content.replaceAll("/CLASS/", TestCase);
        content = content.replaceAll("/FUNCTION/", TestFunction);
        content = content.replaceAll("/SUITE/", TestSuite);

        File tempFile = new File(dst);
        FileUtils.writeStringToFile(tempFile, content, "UTF-8");

        if(file.exists()){
            System.out.println(content);

//            File dest = new File(dst);
//
//            FileUtils.copyFile(tempFile,dest,true);
        } else {
            System.out.println("File not exists" + this.getApplicationDir());
        }




    }

    protected String getApplicationDir() {
        //src/main/java/com/generator/test_suites
        String appPath = "C:/Projects/java-projects/javaclassgenerator/";
        return appPath;
    }

    protected String getOutputDir() {
        String outputDir = getApplicationDir() + "/source/target/test_data/outputDir/";
        outputDir = outputDir.replace("/", "\\");
        File f1 = new File(outputDir);
        if (!f1.exists()) {
            try{
                f1.mkdir();
            }
            catch(SecurityException e){
                System.out.println(e.getMessage());
            }
        }
        File f = new File(outputDir);
        return outputDir;
    }

}
