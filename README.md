# F1StatsApp

## F1StatsApp is a full-stack application composed of:
- a frontend built with Node.js
- a backend built with Java (Spring Boot)

A Bash script is provided to build both parts and start the application automatically.

## REQUIREMENTS

Before running the application, ensure the following are installed.

Java
- Java 21 is required

Verify:
```
java -version
```

Node.js & npm
- Node.js (includes npm) is required

Verify:
```
node -v
npm -v
```

## INSTALLATION & RUNNING THE APPLICATION

1. Clone the repository
```
git clone git@github.com:AlessioBianchi/F1Stats.git F1StatsApp
cd F1StatsApp
```

2. Make the build script executable (one time only)
```
chmod +x build_and_run.sh
```

3. Build and run the application
```
./build_and_run.sh
```

The script will:
- install frontend dependencies
- build the frontend
- build the backend
- copy frontend files into the backend
- start the application

## ACCESSING THE APPLICATION

Open your browser and navigate to:

`http://localhost:8080/`

The application is now running.

## TROUBLESHOOTING

- Ensure java, node, and npm are available in your PATH
- If chmod does not work, run the script with: `bash build_and_run.sh`
- On Windows (WSL), make sure the project is located inside your Linux home directory
