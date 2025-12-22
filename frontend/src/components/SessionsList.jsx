import { useEffect, useState } from "react";
import { fetchSessions } from "../api/f1Api";
import SessionsCircuitList from "./SessionsCircuitList";

export default function SessionsList() {
  const [sessions, setSessions] = useState([]);
  const [selectedCircuit, setSelectedCircuit] = useState(null);

  useEffect(() => {
    fetchSessions().then(data => {
      setSessions(data);
    });
  }, []);

  return (
    <div style={{ display: "flex", gap: "2rem", height: "100%" }}>
      {/* Left: Scrollable Circuit List */}
      <ul
        style={{
          flex: "1",
          minWidth: "400px",
          maxWidth: "500px",
          overflowY: "auto", // enables scrolling
          borderRight: "1px solid #ccc",
          paddingRight: "1rem"
        }}
      >
        {sessions.map(session => (
          <li key={session.session_key}>
            <button
              style={{ width: "100%", textAlign: "left", padding: "0.5rem" }}
              onClick={() => setSelectedCircuit(session)}
            >
              {session.location}, {session.country_name}
            </button>
          </li>
        ))}
      </ul>

      {/* Right: Sticky / Fixed Circuit Details */}
      <div
        style={{
          flex: "2",
          position: "sticky",
          top: 0,
          alignSelf: "flex-start" // ensures it stays at top of parent flex container
        }}
      >
        {selectedCircuit ? (
          <SessionsCircuitList circuit={selectedCircuit} />
        ) : (
          <div>Select a circuit to see details</div>
        )}
      </div>
    </div>
  );
}
