pipeline
{
agent any
	tools {
		maven "maven"
	       }
	stages
	{
		stage('Maven install')
		{
		steps 
		{
        	git branch: 'main', url: 'https://github.com/shiva466/NutriApp.git'
	        withMaven
		(
          	maven: 'maven'
        	)
		{
          	bat "mvn -Dmaven.test.skip=true install"
        	}
      		}
		}
		stage('Mock Test') {
            	steps {
                sh 'mvn test -Dtest=ait.student.nutrition'
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
