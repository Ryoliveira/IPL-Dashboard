import React from 'react';

export const MatchDetailCard = ({match}) => {
    if(!match) return null;
    return (
        <div className="MatchDetailCard">
            <h3>Latest Matches</h3>
            <h4>Match Details</h4>
            <h5>{match.team1} VS {match.team2}</h5>
        </div>
    );
}