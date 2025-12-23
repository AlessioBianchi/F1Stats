import { useEffect, useState } from "react";
import { fetchSessionsByCircuit } from "../api/f1Api";

export default function SessionsCircuitList({ circuit, year }) {
  const [circuitSessions, setCircuitSessions] = useState([]);

  useEffect(() => {
    if (!circuit || !year) return;

    fetchSessionsByCircuit(year, circuit.circuit_short_name)
      .then(setCircuitSessions);

  }, [circuit, year]);

  return (
    <div>
      <h3>Sessions for {circuit.location}</h3>
      <ul>
        {circuitSessions.map(s => (
          <li key={s.session_key}>
            {s.session_name}, {s.date_start} - {s.date_end}
          </li>
        ))}
      </ul>
    </div>
  );
}
