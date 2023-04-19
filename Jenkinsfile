pipeline
{
agent any
	tools {
		maven "maven"
	       }
	stages
	{
		stage('Maven install') {
 
      steps {
        
        withMaven(
          maven: 'maven'
        ) {
        
          bat "mvn -Dmaven.test.skip=true install"
        }
      }
 
      post {
        success {
          junit '*/target/surefire-reports/TEST-.xml'
          archiveArtifacts 'target/*.jar'
        }
      }
    }
    
		
		stage('scan pages')
		{
			steps
			{
				 withSonarQubeEnv('nutrisonar')
				{
				withMaven(maven:'maven')
				{
					bat "mvn sonar:sonar"
				}
				}
			}
		}	
	}
}
