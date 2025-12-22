import { useState } from "react";
import DriverList from "../components/DriverList";
import SessionsList from "../components/SessionsList";

const TABS = {
  CIRCUITS: "circuits",
  DRIVERS: "drivers"
};

export default function Home() {
  const [activeTab, setActiveTab] = useState(TABS.CIRCUITS);

  return (
    <div style={{ display: "flex", flexDirection: "column", width: "100vw", height: "100vh" }}>
      {/* Sticky header + tabs */}
      <div style={{ position: "sticky", top: 0, zIndex: 10, padding: "1rem" }}>
        <h1 style={{ margin: 0 }}>🏎️ Formula 1 Stats</h1>

        {/* Tabs */}
        <div style={{ display: "flex", gap: "1rem", marginTop: "0.5rem" }}>
          <button
            onClick={() => setActiveTab(TABS.CIRCUITS)}
            style={{ fontWeight: activeTab === TABS.CIRCUITS ? "bold" : "normal" }}
          >
            Circuits
          </button>
          <button
            onClick={() => setActiveTab(TABS.DRIVERS)}
            style={{ fontWeight: activeTab === TABS.DRIVERS ? "bold" : "normal" }}
          >
            Drivers
          </button>
        </div>

        <hr style={{ marginTop: "1rem" }} />
      </div>

      {/* Scrollable content fills remaining space */}
      <div style={{ flex: 1, overflowY: "auto", padding: "1rem" }}>
        {activeTab === TABS.CIRCUITS && <SessionsList />}
        {activeTab === TABS.DRIVERS && <DriverList />}
      </div>
    </div>
  );
}
