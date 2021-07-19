import React, {useEffect, useState} from 'react';
import {useParams} from 'react-router-dom'
import {MatchDetailCard} from "../components/MatchDetailCard";

import './MatchPage.scss';
import {YearSelector} from "../components/YearSelector";

export const MatchPage = () => {

    const [matches, setMatches] = useState([]);
    const {teamName, year} = useParams();
    useEffect(
        () => {
            const fetchMatches = async () => {
                const response = await fetch(`${process.env.REACT_APP_API_ROOT_URL}/team/${teamName}/matches?year=${year}`);
                const data = await response.json();
                setMatches(data);
            };
            fetchMatches();
        }, [teamName, year]
    );

    return (
        <div className="MatchPage">
            <div className="year-selector">
                <h3 className="page-heading">Select Year</h3>
                <YearSelector teamName={teamName}/>
            </div>
            <div>
                <h1>{teamName} - {year}</h1>
                {matches.length !== 0 ?
                    matches.map(match => <MatchDetailCard key={match.id} teamName={teamName} match={match}/>)
                    : <h2>No Matches for selected year {year}</h2>}
            </div>
        </div>
    );
}