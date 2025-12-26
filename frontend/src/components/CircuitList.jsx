import SessionResults from "./SessionResults";
import { useEffect, useMemo, useState } from "react";
import { fetchSessionsByCircuit } from "../api/f1Api";

export default function SessionsCircuitList({ circuit, year }) {
  const [sessions, setSessions] = useState([]);
  const [activeTab, setActiveTab] = useState(null);

  useEffect(() => {
    if (!circuit || !year) return;

    fetchSessionsByCircuit(year, circuit.circuit_short_name)
      .then(data => {
        setSessions(data);
      });

  }, [circuit, year]);

  /**
   * Group sessions by type (Practice, Qualifying, Race, Sprint)
   */
  const sessionsByType = useMemo(() => {
    const map = {};

    sessions.forEach(s => {
      const type = s.session_name;
      if (!map[type]) {
        map[type] = [];
      }
      map[type].push(s);
    });

    return map;
  }, [sessions]);

  /**
   * Available tabs (only those with data)
   */
  const availableTabs = Object.keys(sessionsByType);

  /**
   * Session Key selected
   */
  const activeSessionKey = useMemo(() => {
    if (!activeTab || !sessionsByType[activeTab]) return null;

    // Sort by date_start and take the latest session
    const sorted = [...sessionsByType[activeTab]].sort(
      (a, b) => new Date(a.date_start) - new Date(b.date_start)
    );

    return sorted[sorted.length - 1].session_key;
  }, [activeTab, sessionsByType]);

  /**
   * Select first available tab by default
   */
  useEffect(() => {
    if (availableTabs.length > 0) {
      setActiveTab(availableTabs[0]);
    }
  }, [availableTabs.join(",")]);

  if (!circuit) return null;

  return (
    <div>
      <h3>{circuit.location}</h3>

      {/* Tabs */}
      <div style={{ display: "flex", gap: "0.5rem", marginBottom: "1rem" }}>
        {availableTabs.map(type => (
          <button
            key={type}
            onClick={() => setActiveTab(type)}
            style={{
              padding: "0.5rem 1rem",
              borderRadius: "8px",
              border: "1px solid #ccc",
              background: activeTab === type ? "#000" : "#f5f5f5",
              color: activeTab === type ? "white" : "black",
              cursor: "pointer"
            }}
          >
            {type}
          </button>
        ))}
      </div>

      {/* Tab content */}
      {activeTab && (
        <SessionResults sessionKey={activeSessionKey} />
      )}
    </div>
  );
}