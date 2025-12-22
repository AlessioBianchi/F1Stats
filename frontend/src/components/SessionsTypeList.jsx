import { useEffect, useState } from "react";
import { fetchSessionsBySessionType, fetchSessionsByYear } from "../api/f1Api";

export default function SessionsTypeList() {
  const [sessions, setSessions] = useState([]);

  useEffect(() => {
    fetchSessionsBySessionType().then(data => {
      setSessions(data);
    });
  }, []);

  return (
    <div>
      <h2>F1 Circuits</h2>
      <ul>
        {sessions.map(session => (
          <li key={session.session_key}>
            {session.location}, {session.country_name}: {session.session_type}
          </li>
        ))}
      </ul>
    </div>
  );
}
