const { app, BrowserWindow } = require("electron");
const { spawn } = require("child_process");
const path = require("path");
const http = require("http");

let backendProcess;

function waitForBackend(url, callback) {
  const interval = setInterval(() => {
    http
      .get(url, () => {
        clearInterval(interval);
        callback();
      })
      .on("error", () => {});
  }, 500);
}

app.whenReady().then(() => {
  // ONE backend start
  const jarPath = path.join(__dirname, "f1stats-0.0.1-SNAPSHOT.jar");

  backendProcess = spawn("java", ["-jar", jarPath]);

  backendProcess.stdout.on("data", (data) => {
    console.log(`[BACKEND]: ${data}`);
  });

  backendProcess.stderr.on("data", (data) => {
    console.error(`[BACKEND ERROR]: ${data}`);
  });

  // ONE window
  const win = new BrowserWindow({
    width: 1200,
    height: 800,
  });

  // WAIT for Spring Boot (NOT Vite)
  waitForBackend("http://localhost:8080", () => {
    win.loadURL("http://localhost:8080");
  });
});

app.on("will-quit", () => {
  if (backendProcess) {
    backendProcess.kill();
  }
});
