import SessionsList from "../components/SessionsList";

export default function Home() {
  return (
    <div
      style={{
        display: "flex",
        flexDirection: "column",
        width: "100vw",
        height: "100vh"
      }}
    >
      {/* Sticky header */}
      <div style={{ position: "sticky", top: 0, zIndex: 10, padding: "1rem 1rem 0 1rem" }}>
        <h1 style={{ margin: 0 }}>🏎️ Formula 1 Stats</h1>
        <hr style={{ marginTop: "1rem" }} />
      </div>

      {/* Content */}
      <div style={{ flex: 1, overflow: "hidden", padding: "0 1rem 1rem 1rem" }}>
        <SessionsList />
      </div>
    </div>
  );
}
