const BASE_URL = "http://localhost:8080/api";

export async function fetchDrivers() {
  const response = await fetch(`${BASE_URL}/drivers`);
  return response.json();
}
