
# Another Notes App

This is a simple note taking app in Android with Integrated API. In this project we have covered everything that is required to create a fully functional app.



## Features

- MVVM Setup
- HILT
- Coroutines
- API Integration using Retrofit
- Interceptors for Authenticated Flows.
- Handling validations and loading state.
- Complete Signup/Login Flow 

# Step 1. Add the JitPack repository to your build file


allprojects {
		repositories {
			...
			maven 
      { 
      url 'https://jitpack.io' 
      }
		}
	}

# Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.Waqas098:NoteApp:Tag'
	}
