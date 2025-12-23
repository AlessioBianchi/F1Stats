const BASE_URL = "http://localhost:8080/api";

export async function fetchDrivers() {
  const response = await fetch(`${BASE_URL}/drivers`);
  return response.json();
}

// export async function fetchSessions() {
//     const response = await fetch(`${BASE_URL}/sessions`)
//     return response.json();
// }

export async function fetchSessionsByYear(year) {
    const response = await fetch(`${BASE_URL}/sessions?year=`+year)
    return response.json();
}

export async function fetchSessionsByCircuit(year, circuitName) {
    const response = await fetch(`${BASE_URL}/sessions/info?year=`+year+`&circuitName=`+circuitName)
    return response.json();
}