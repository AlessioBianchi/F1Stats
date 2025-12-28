#!/usr/bin/env bash
set -euo pipefail

# -------- Paths --------
FRONTEND_DIR="./frontend"
BACKEND_DIR="./backend/f1stats"
STATIC_DIR="$BACKEND_DIR/src/main/resources/static"
ASSETS_DIR="$STATIC_DIR/assets"
JAR_PATH="$BACKEND_DIR/build/libs/f1stats-0.0.1-SNAPSHOT.jar"

# -------- Frontend build --------
echo "Building frontend..."
cd "$FRONTEND_DIR"
npm install
npm run build
cd - >/dev/null

# -------- Backend build --------
echo "Building backend..."
cd "$BACKEND_DIR"
./gradlew bootJar
cd - >/dev/null

# -------- Copy frontend build to backend --------
echo "Copying frontend files to backend static directory..."
mkdir -p "$ASSETS_DIR"

cp "$FRONTEND_DIR/dist/index.html" "$STATIC_DIR/"
cp "$FRONTEND_DIR/dist/assets/"* "$ASSETS_DIR/"

# -------- Run application --------
echo "Starting application..."
java -jar "$JAR_PATH"
