/* Copyright 2015 Richard Wiedenhöft <richard@wiedenhoeft.xyz>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.package net.metanoise.android.jenastop
 */
package net.metanoise.android.jenastop

case class Station(
    name: String,
    favorite: Boolean) extends Ordered[Station] {

  def setFavorite(favorite: Boolean)(implicit db: DatabaseHelper): Station = {
    db.setFavorite(this, favorite)
    this.copy(favorite = favorite)
  }

  def compare(other: Station): Int = {
    if (this.favorite && !other.favorite) {
      -1
    } else if (!this.favorite && other.favorite) {
      1
    } else {
      name.compare(other.name)
    }
  }
}
