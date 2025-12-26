import { useEffect, useState } from "react";
import { fetchSessionResults } from "../api/f1Api";

export default function SessionResults({ sessionKey }) {
  const [results, setResults] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    if (!sessionKey) return;

    setLoading(true);
    fetchSessionResults(sessionKey)
      .then(data => {
        setResults(data);
        setLoading(false);
      });
  }, [sessionKey]);

  if (loading) {
    return <div>Loading results…</div>;
  }

  return (
    <table style={tableStyle}>
      <colgroup>
        <col style={{ width: "44px" }} />
        <col />
        <col style={{ width: "54px" }} />
      </colgroup>

      <thead>
        <tr>
          <th style={thPos}>Pos</th>
          <th style={thDriver}>Driver</th>
          <th style={thGap}>Gap</th>
        </tr>
      </thead>

      <tbody>
        {results.map(row => (
          <tr key={row.driver_number} style={{ borderBottom: "1px solid #eee" }}>
            <td style={tdPos}>{row.position ?? "OUT"}</td>

            <td style={tdDriver}>
              <div style={driverCell}>
                <img
                  src={row.driverInfo?.headshot_url}
                  alt={row.driverInfo?.full_name}
                  style={driverImg}
                />
                <span style={driverName}>
                  {row.driverInfo?.full_name}
                </span>
              </div>
            </td>

            <td style={tdGap}>
              {formatGap(row.gap_to_leader)}
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

function formatGap(gap) {
  if (gap === null || gap === undefined) return "-";
  if (gap[0] === 0) return "";
  return `+${gap[0]}`;
}

const tableStyle = {
  width: "100%",
  borderCollapse: "collapse",
  boxShadow: "0 4px 20px rgba(0,0,0,0.1)",
  borderRadius: "12px"
};

const thPos = {
  padding: "0.75rem",
  textAlign: "right",
  background: "#111",
  color: "white"
};

const thGap = {
  padding: "0.75rem",
  textAlign: "right",
  background: "#111",
  color: "white"
};

const tdPos = {
  padding: "0.75rem",
  textAlign: "right",
  fontWeight: 600
};

const tdGap = {
  padding: "0.75rem",
  textAlign: "right",
  color: "#666",
  whiteSpace: "nowrap"
};

const thDriver = {
  padding: "0.75rem",
  textAlign: "left",
  background: "#111",
  color: "white"
};

const tdDriver = {
  padding: "0.75rem",
  overflow: "hidden"
};

const driverCell = {
  display: "flex",
  alignItems: "center",
  gap: "0.75rem",
  overflow: "hidden"
};

const driverImg = {
  width: "36px",
  height: "36px",
  borderRadius: "50%",
  objectFit: "cover",
  flexShrink: 0
};

const driverName = {
  whiteSpace: "nowrap",
  overflow: "hidden",
  textOverflow: "ellipsis"
};