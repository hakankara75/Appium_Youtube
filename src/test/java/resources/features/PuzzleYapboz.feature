
Feature: Puzzle_Yapboz_Menusu
  Background: Giris
    Given Kitap Yurdu sitesine gidildi
    Then Kitap Yurdu sitesine gidildigi dogrulandi
    When Kategoriler ikonu tiklandi
    And "Kategoriler" bolumunde oldugu dogrulandi
    Then "Puzzle Yapboz" menusu tiklandi
    And "Puzzle Yapboz" bolumunde oldugu dogrulandi

  Scenario: Ahsap Puzzle Menusu Testi
    Given "Ahsap Puzzle" menusu tiklandi
    When "Ahşap Puzzle" bolumunde oldugu dogrulandi
    Then "300 Parça" menusu tiklandi
    And "300 Parça" bolumunde oldugu dogrulandi
    Then "Lava" menusu tiklandi
    And Sayfada "yazilan" sayida urun oldugu dogrulandi


  Scenario: Çocuk Puzzle Menusu Testi
    Given "Çocuk Puzzle" menusu tiklandi
    When "Çocuk Puzzle" bolumunde oldugu dogrulandi
    Then "6-48 PARÇA" menusu tiklandi
    And "6-48 PARÇA" bolumunde oldugu dogrulandi
    And Sayfada "yazilan" sayida urun oldugu dogrulandi
  @puzzle
  Scenario: Slip Testi
    Given "Ahsap Puzzle" menusu tiklandi
    When "Ahsap Puzzle" bolumunde oldugu dogrulandi
    Then "Ahşap Puzzle (1000 Parça)" menusu tiklandi
    And "Ahşap Puzzle (1000 Parça)" bolumunde oldugu dogrulandi
    Then "Türk Sanatı Serisi" menusu tiklandi
    And "Türk Sanatı Serisi" bolumunde oldugu dogrulandi
    And Urunu tikladi
    And Urunu slip yapti
