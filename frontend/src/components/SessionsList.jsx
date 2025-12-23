import { useEffect, useState } from "react";
import { fetchSessionsByYear } from "../api/f1Api";
import SessionsCircuitList from "./SessionsCircuitList";

const CURRENT_YEAR = new Date().getFullYear();
const LAST_YEAR_AVAILABLE = 2023;
const HEADER_HEIGHT = "56px";

export default function SessionsList() {
  const [sessions, setSessions] = useState([]);
  const [selectedCircuit, setSelectedCircuit] = useState(null);
  const [year, setYear] = useState(CURRENT_YEAR);

  useEffect(() => {
    fetchSessionsByYear(year).then(data => {
      setSessions(data);

      if (data && data.length > 0) {
        setSelectedCircuit(data[0]);
      } else {
        setSelectedCircuit(null);
      }
    });
  }, [year]);

  return (
    <div
      style={{
        display: "flex",
        height: "100%",
        overflow: "hidden"
      }}
    >
      {/* LEFT TAB — Circuit list */}
      <div
        style={{
          flex: "0 0 450px",
          display: "flex",
          flexDirection: "column",
          borderRight: "1px solid #ccc"
        }}
      >
        {/* Year navigation */}
        <div
          style={{
            height: HEADER_HEIGHT,
            display: "flex",
            alignItems: "center",
            justifyContent: "space-between",
            padding: "0 1rem",
            borderBottom: "1px solid #ccc",
            boxSizing: "border-box"
          }}
        >
          {/* Left arrow */}
          <button
            onClick={() => setYear(y => y - 1)}
            disabled={year <= LAST_YEAR_AVAILABLE}
          >
            ⬅
          </button>

          {/* Center year */}
          <strong style={{ textAlign: "center" }}>{year}</strong>

          {/* Right arrow */}
          <button
            onClick={() => setYear(y => y + 1)}
            disabled={year >= CURRENT_YEAR}
          >
            ➡
          </button>
        </div>

        {/* Scrollable list */}
        <ul
          style={{
            flex: 1,
            overflowY: "auto",
            padding: "1rem",
            margin: 0
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
      </div>

      {/* RIGHT TAB — Circuit details */}
      <div
        style={{
          flex: "0 0 100%",
          display: "flex",
          flexDirection: "column"
        }}
      >
        {/* Tabs navigation */}
        <div
          style={{
            height: HEADER_HEIGHT,
            display: "flex",
            alignItems: "center",
            gap: "1rem",
            padding: "0 1rem",
            borderBottom: "1px solid #ccc",
            boxSizing: "border-box"
          }}
        >
          {/* Live tab */}
          <button
            /*onClick={TODO}*/
          >
            Live
          </button>

          {/* Results tab */}
          <button
            /*onClick={TODO}*/
          >
            Results
          </button>
        </div>

        {/* Content */}
        <div
          style={{
            flex: 1,
            overflowY: "auto",
            padding: "1rem"
          }}
        >
          {selectedCircuit && (
            <SessionsCircuitList year={year} circuit={selectedCircuit} />
          )}
        </div>
      </div>
    </div>
  );
}
