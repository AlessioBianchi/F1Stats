import { useEffect, useState } from "react";
import { fetchSessionsByYear } from "../api/f1Api";
import CircuitList from "./CircuitList";

const CURRENT_YEAR = new Date().getFullYear();
const LAST_YEAR_AVAILABLE = 2023;
const HEADER_HEIGHT = "56px";

export default function SessionsList() {
  const [loading, setLoading] = useState(true);
  const [sessions, setSessions] = useState([]);
  const [selectedCircuit, setSelectedCircuit] = useState(null);
  const [year, setYear] = useState(CURRENT_YEAR);

  useEffect(() => {
    setLoading(true);
    fetchSessionsByYear(year).then(data => {
      setSessions(data);
      setLoading(false);
      if (data && data.length > 0) {
        setSelectedCircuit(data[0]);
      } else {
        setSelectedCircuit(null);
      }
    });
  }, [year]);

  if (loading) {
    return <div>Loading results…</div>;
  }

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
            margin: 0,
            listStyle: "none"
          }}
        >
          {sessions.map(session => {
            const isSelected =
              selectedCircuit?.session_key === session.session_key;

            return (
              <li key={session.session_key} style={{ marginBottom: "0.5rem" }}>
                <button
                  onClick={() => setSelectedCircuit(session)}
                  style={{
                    width: "100%",
                    display: "grid",
                    gridTemplateColumns: "140px 1fr 160px",
                    alignItems: "center",
                    gap: "0.5rem",
                    padding: "0.75rem",
                    //border: "none",
                    borderRadius: "10px",
                    cursor: "pointer",
                    //background: isSelected ? "#f0f0f0" : "white",
                    boxShadow: isSelected
                      ? "0 6px 18px rgba(0,0,0,0.18)"
                      : "0 1px 4px rgba(0,0,0,0.08)",
                    transition: "all 0.2s ease",
                    textAlign: "left"
                  }}
                >
                  {/* Country */}
                  <span style={{ fontWeight: "bold" }}>
                    {session.country_name}
                  </span>

                  {/* Location */}
                  <span>
                    {session.location}
                  </span>

                  {/* Dates */}
                  <span
                    style={{
                      textAlign: "right"
                    }}
                  >
                    {formatDateRange(
                      session.date_start,
                      session.date_end
                    )}
                  </span>
                </button>
              </li>
            );
          })}
        </ul>
      </div>

      {/* RIGHT TAB — Circuit details */}
      <div
        style={{
          flex: "0 0 calc(100% - 500px)",
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
            <CircuitList year={year} circuit={selectedCircuit} />
          )}
        </div>
      </div>
    </div>
  );
}

function formatDateRange(start, end) {
  const options = { day: "2-digit", month: "short" };

  const startDate = new Date(start);
  const endDate = new Date(end);

  return `${startDate.toLocaleDateString("en-GB", options)} - ${endDate.toLocaleDateString("en-GB", options)}`;
}