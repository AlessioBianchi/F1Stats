import { useEffect, useState } from "react";
import { fetchDrivers } from "../api/f1Api";

export default function DriverList() {
  const [drivers, setDrivers] = useState([]);

  useEffect(() => {
    fetchDrivers().then(data => {
      setDrivers(data);
    });
  }, []);

  return (
    <div>
      <h2>F1 Drivers</h2>
      <ul>
        {drivers.map(driver => (
          <li key={driver.driver_number}>
            {driver.driver_number} {driver.full_name} ({driver.team_name})
          </li>
        ))}
      </ul>
    </div>
  );
}
