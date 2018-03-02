/**
 * 
 */
package com.football.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.football.entity.Team;

/**
 * @author hp
 *
 */
@RequestScoped
@Path("/teams")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class TeamEndpoint {

	/**
	* @param startPosition
	* @param maxResult
	* @return
	*/
	@GET
	public List<Team> listAll(@QueryParam("start") final Integer startPosition,
			@QueryParam("max") final Integer maxResult) {
		//TODO: retrieve the teams 
		final List<Team> teams = null;
		return teams;
	}

}
