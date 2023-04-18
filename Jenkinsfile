pipeline {
agent any
stages
  {
  stage('scan pages')
  {
   steps
    {
   withSonarQubeEnv(installationName: 'nutrisonar')
    	{
	
  		sh 'mvn clean org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar'
    	}
	}
  }
 } 
}
